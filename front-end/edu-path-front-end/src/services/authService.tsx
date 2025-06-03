import axios from "axios";

const API_URL = "http://localhost:8081/api/auth";

const authService = {
  login: async (username: string, password: string) => {
    try {
      const response = await axios.post(`${API_URL}/signin`, {
        username,
        password,
      });

      const { token, refreshToken } = response.data;
      localStorage.setItem("token", token);
      localStorage.setItem("refreshToken", refreshToken);
      localStorage.setItem("user", JSON.stringify(response.data));

      return response.data;
    } catch (error) {
      throw new Error("Falha ao realizar login");
    }
  },

  register: async (data: { username: string; password: string }) => {
    try {
      const response = await axios.post(`${API_URL}/signup`, data);
      return response.data;
    } catch (error) {
      throw new Error("Falha ao realizar registro");
    }
  },

  logout: () => {
    localStorage.removeItem("token");
    localStorage.removeItem("refreshToken");
    localStorage.removeItem("user");
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
