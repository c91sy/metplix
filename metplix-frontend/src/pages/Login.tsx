import React from 'react'

type LoginProps = {
  setIsLoggedIn: React.Dispatch<React.SetStateAction<boolean>>;
};

const Login= ({ setIsLoggedIn }: LoginProps) => {
  return (
    <div>Login</div>
  )
};
export default Login;
