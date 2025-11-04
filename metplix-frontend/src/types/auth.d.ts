//인증과 관련된 타입만 모아둔 선언 파일
export interface LoginResponse {
    success: boolean;
    code: string;
    data: {
        accessToken: string;
        refreshToken: string;
    };  //axios 요청 결과의 응답 구조를 타입스크립트에게 명확하게 알려주기 위해
}       //로그인 API가 서버에서 보내주는 응답의 형태를 정의