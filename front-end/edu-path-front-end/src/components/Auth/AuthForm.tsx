import { useState } from "react";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import authService from "../../services/authService";

interface FormData {
  username: string;
  password: string;
}

export default function AuthForm() {
  const [isLogin, setIsLogin] = useState(true);
  const [error, setError] = useState("");
  const navigate = useNavigate();
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<FormData>();

  const onSubmit = async (data: FormData) => {
    try {
      setError("");
      const response = isLogin
        ? await authService.login(data.username, data.password)
        : await authService.register(data);

      localStorage.setItem("token", response.token);
      navigate("/courses");
    } catch (err) {
      setError("Falha na autenticação. Verifique suas credenciais.");
    }
  };

  return (
    <div className="min-h-screen flex items-center justify-center">
      <div className="bg-vscode-dark-900 p-8 rounded-lg shadow-lg w-full max-w-md">
        <h2 className="text-2xl font-bold mb-6 text-center">
          {isLogin ? "Login" : "Registro"}
        </h2>

        <form onSubmit={handleSubmit(onSubmit)} className="space-y-4">
          <div>
            <input
              {...register("username", {
                required: true,
                minLength: {
                  value: 3,
                  message: "Username deve ter pelo menos 3 caracteres",
                },
              })}
              type="text"
              placeholder="Username"
              className="w-full p-3 rounded bg-vscode-dark-800 border border-vscode-dark-700 focus:outline-none focus:border-blue-500"
            />
            {errors.username && (
              <span className="text-red-500 text-sm">
                {errors.username.message || "Username é obrigatório"}
              </span>
            )}
          </div>

          <div>
            <input
              {...register("password", {
                required: true,
                minLength: {
                  value: 6,
                  message: "Senha deve ter pelo menos 6 caracteres",
                },
              })}
              type="password"
              placeholder="Senha"
              className="w-full p-3 rounded bg-vscode-dark-800 border border-vscode-dark-700 focus:outline-none focus:border-blue-500"
            />
            {errors.password && (
              <span className="text-red-500 text-sm">
                {errors.password.message || "Senha é obrigatória"}
              </span>
            )}
          </div>

          {error && (
            <div className="text-red-500 text-sm text-center">{error}</div>
          )}

          <button
            type="submit"
            className="w-full bg-blue-600 hover:bg-blue-700 text-white font-bold py-3 px-4 rounded transition duration-200"
          >
            {isLogin ? "Entrar" : "Registrar"}
          </button>

          <div className="text-center mt-4">
            <button
              type="button"
              onClick={() => setIsLogin(!isLogin)}
              className="text-blue-400 hover:text-blue-500"
            >
              {isLogin
                ? "Não tem uma conta? Registre-se"
                : "Já tem uma conta? Entre"}
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
