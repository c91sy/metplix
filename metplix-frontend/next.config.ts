import type { NextConfig } from "next";

const nextConfig: NextConfig = {
    async rewrites() {
        return [
            {
                source: "/api/:path*",
                destination: "http://localhost:8080/api/:path*",
            },
        ];
    }
};

export default nextConfig;

/*Next.js 13 이상 프로젝트에서는 packge.json에서 proxy 설정이 적용되지 않습니다.
대신 API 라우트를 활용하거나, next.config.js에서 리라이트(rewrites) 설정을 해야 합니다*/