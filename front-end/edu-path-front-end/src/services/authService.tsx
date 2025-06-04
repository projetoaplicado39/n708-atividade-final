import axios from "axios";

const API_URL = "http://localhost:8081/api/auth";

const authService = {
  login: async (username: string, password: string) => {
    try {
      const response = await axios.post(`${API_URL}/signin`, {
        username,
        password,
      });

      const { token, refreshToken, userId, id } = response.data;
      const resolvedUserId = userId || id;

      if (resolvedUserId) {
        localStorage.setItem("userId", resolvedUserId);
      }

      localStorage.setItem("token", token);
      localStorage.setItem("refreshToken", refreshToken);
      localStorage.setItem("user", JSON.stringify(response.data));

      return response.data;
    } catch (error) {
      throw new Error("Falha ao realizar login");
    }
  },

  register: async (data: {
    username: string;
    email: string;
    password: string;
  }) => {
    try {
      const response = await axios.post(`${API_URL}/signup`, data);

      const { userId, id } = response.data;
      const resolvedUserId = userId || id;

      if (resolvedUserId) {
        localStorage.setItem("userId", resolvedUserId);
      }

      return {
        success: true,
        data: response.data,
        message: "Registro realizado com sucesso!",
      };
    } catch (error: any) {
      if (
        error.response &&
        error.response.data &&
        error.response.data.message
      ) {
        return { success: false, message: error.response.data.message };
      }

      return {
        success: false,
        message: "Falha ao realizar registro. Tente novamente.",
      };
    }
  },

  logout: () => {
    localStorage.removeItem("token");
    localStorage.removeItem("refreshToken");
    localStorage.removeItem("user");
    localStorage.removeItem("userId");
  },

  getCurrentUser: () => {
    const userStr = localStorage.getItem("user");
    if (userStr) return JSON.parse(userStr);
    return null;
  },

  isAuthenticated: () => {
    return !!localStorage.getItem("token");
  },
};

export default authService;
