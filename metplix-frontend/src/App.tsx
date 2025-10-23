import React, {useState, useEffect} from 'react';
import {BrowserRouter as Router, Link, Route, Routes} from 'react-router-dom';
import './App.css';
import Main from "./pages/Main";
import Login from "./pages/Login";
import Signup from "./pages/Signup";
import KakaoAuthRedirect from "./pages/KakaoAuthRedirect";
import ProtectedRoute from "./routes/ProtectedRoute";
import Dashboard from "./pages/Dashboard";

function App() {
    const [isLoggedIn, setIsLoggedIn] = useState(false); // 초기 상태 (로그아웃상태)

    useEffect(() => {
        const token = localStorage.getItem('token');
        if (token) setIsLoggedIn(true);
    }, []);

    const handleLogout = async (e: React.MouseEvent<HTMLButtonElement>) => {
        e.preventDefault();
        try {
            localStorage.removeItem('token'); // 저장된 로그인 토큰 삭제
            setIsLoggedIn(false);
        } catch (error) {
            alert('로그아웃 실패');
        }
    };

  return (
      <Router>
          <div>
              <div className="container">
                  {/*상단 네비*/}
                  <nav className="navbar navbar-expand-lg navbar-light bg-light">
                      <Link className="navbar-brand" to="/">Metplix</Link>
                      <div className="collapse navbar-collapse">
                          <ul className="navbar-nav ms-auto">
                              {
                                  !isLoggedIn ? (
                                      <>
                                          <li className="nav-item">
                                              <Link className="nav-link" to="/login">로그인</Link>
                                          </li>
                                          <li className="nav-item">
                                              <Link className="nav-link" to="/signup">회원가입</Link>
                                          </li>
                                      </>
                                  ) : (
                                      <>
                                          <li className="nav-item">
                                              <button className="btn btn-danger" onClick={handleLogout}>로그아웃</button>
                                          </li>
                                      </>
                                  )
                              }
                          </ul>
                      </div>
                  </nav>
                  {/*URL 경로에 따라 각 화면 컴포넌트를 연결하는 라우팅 설정  */}
                  <div className="container mt-5">
                      <Routes> {/* 메인 홈페이지, 로그인, 회원가입, 카카오로그인, 관리자 */}
                          <Route path="/" element={<Main/>}/>
                          <Route path="/login" element={<Login setIsLoggedIn={setIsLoggedIn}/>}/>
                          <Route path="/signup" element={<Signup/>}/>
                          <Route path="/login/oauth2/code/kakao" element={<KakaoAuthRedirect/>}/>

                          <Route path="/dashboard" element={
                              <ProtectedRoute>
                                  <Dashboard />
                              </ProtectedRoute>
                          }/>
                      </Routes>
                  </div>

              </div>
          </div>
      </Router>
)
;
}

export default App;
