import React from 'react';
import {Navigate} from "react-router-dom";

type ProtectedRouteProps = {
    children: React.ReactNode;
}

const ProtectedRoute = ({children}: ProtectedRouteProps)=>{
    const token = localStorage.getItem('token'); // 로컬 스토리지에서 토큰 확인 브라우저 닫아도 유지

    // 토큰이 없으면 로그인 페이지로 리디렉션
    if (!token) {
        return <Navigate to="/login" replace />;
    }

    return children;
};

export default ProtectedRoute;

//로그인 안 된 사용자가 보호된 페이지 접근 시 자동 리디렉션