import axios from "axios";
import type { UserProfile } from "../types/user";

const API_URL = "http://localhost:8082/api/v1/users";

export const getUserProfileById = async (id: string): Promise<UserProfile> => {
  const response = await axios.get(`${API_URL}/${id}`);
  return response.data;
};

export const updateUserProfileById = async (
  id: string,
  profile: UserProfile
): Promise<UserProfile> => {
  const response = await axios.put(`${API_URL}/${id}`, profile);
  return response.data;
};

export const getCurrentUserProfile = async (): Promise<UserProfile | null> => {
  const userId = localStorage.getItem("userId");
  if (!userId) {
    console.warn("Nenhum userId encontrado no localStorage.");
    return null;
  }

  try {
    const profile = await getUserProfileById(userId);
    return profile;
  } catch (error) {
    console.error("Erro ao buscar perfil do usuário:", error);
    return null;
  }
};

export const getCurrentUserProfileWithRetry = async (
  retries = 3,
  delay = 1000
): Promise<UserProfile | null> => {
  const userId = localStorage.getItem("userId");
  if (!userId) {
    console.warn("Nenhum userId encontrado no localStorage.");
    return null;
  }

  while (retries > 0) {
    try {
      const profile = await getUserProfileById(userId);
      return profile;
    } catch (error) {
      console.warn(`Tentativa falhou. Restam ${retries - 1} tentativas.`);
      retries--;
      await new Promise((resolve) => setTimeout(resolve, delay));
    }
  }

  console.error(
    "Não foi possível recuperar o perfil do usuário após várias tentativas."
  );
  return null;
};
