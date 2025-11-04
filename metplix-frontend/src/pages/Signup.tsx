import React, { useState, FormEvent } from 'react';
import {useNavigate} from "react-router-dom";
import api from "../api/axios";
import {LoginResponse} from '../types/auth';

type SignupProps = {
  setIsLoggedIn: React.Dispatch<React.SetStateAction<boolean>>;
}

const Signup = ({ setIsLoggedIn }: SignupProps) => {
  const [name, setName] = useState('최세영');
  const [email, setEmail] = useState('c91sy@kakaobank.com');
  const [password1, setPassword1] = useState('1234');
  const [password2, setPassword2] = useState('1234');
  const [phone, setPhone] = useState('010-1234-5678');

  const navigate = useNavigate();

  const handleSubmit = async (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    if (password1 !== password2) {
      alert("비밀번호가 일치하지 않습니다.");
      return;
    }

    try {
      // 1) 회원가입
      const signupResponse = await api.post('/v1/user/register', {
        name,
        password: password1,
        email,
        phone
      });

      if (!signupResponse.data.success) {
        alert('회원가입 실패: ' + signupResponse.data.code);
        return;
      }

      // 2) 회원가입 성공 → 자동 로그인
      const loginResponse = await api.post<LoginResponse>('/v1/auth/login', {
        email,
        password: password1,
      });

      if (!loginResponse.data.success) {
        alert("자동 로그인 실패. 로그인 페이지로 이동합니다.");
        navigate('/login');
        return;
      }

      // 3) 토큰 저장
      localStorage.setItem('token', loginResponse.data.data.accessToken);
      localStorage.setItem('refresh_token', loginResponse.data.data.refreshToken);

      // 4) 로그인 상태 반영
      setIsLoggedIn(true);

      // 5) 이동
      navigate('/dashboard');

    } catch (error) {
      console.error('Signup/Login failed:', error);
      alert('회원가입 실패 또는 자동 로그인 실패');
    }
  };


  return (
      <div className="container d-flex justify-content-center align-items-center vh-100">
        <div className="card shadow-sm p-4" style={{width: '100%', maxWidth: '400px'}}>
          <h3 className="text-center mb-4">회원가입</h3>
          <form onSubmit={handleSubmit}>
            <div className="mb-3">
              <label htmlFor="email" className="form-label">이메일</label>
              <input
                  type="email"
                  className="form-control"
                  id="email"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                  required
              />
            </div>
            <div className="mb-3">
              <label htmlFor="password1" className="form-label">비밀번호</label>
              <input
                  type="password"
                  className="form-control"
                  id="password1"
                  value={password1}
                  onChange={(e) => setPassword1(e.target.value)}
                  required
              />
            </div>
            <div className="mb-3">
              <label htmlFor="password2" className="form-label">비밀번호 확인</label>
              <input
                  type="password"
                  className="form-control"
                  id="password2"
                  value={password2}
                  onChange={(e) => setPassword2(e.target.value)}
                  required
              />
            </div>
            <div className="mb-3">
              <label htmlFor="name" className="form-label">사용자 명</label>
              <input
                  type="text"
                  className="form-control"
                  id="name"
                  value={name}
                  onChange={(e) => setName(e.target.value)}
                  required
              />
            </div>
            <div className="mb-3">
              <label htmlFor="phone" className="form-label">전화번호</label>
              <input
                  type="text"
                  className="form-control"
                  id="phone"
                  value={phone}
                  onChange={(e) => setPhone(e.target.value)}
                  required
              />
            </div>
            <button type="submit" className="btn btn-primary w-100">
              회원가입
            </button>
          </form>
        </div>
      </div>
  );
}

export default Signup;
