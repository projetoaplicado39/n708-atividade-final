import axios from "axios";
import type { UserProfile } from "../types/user";

const API_URL = "http://localhost:8082/api/v1";

export const getUserProfile = async (): Promise<UserProfile> => {
  const response = await axios.get(`${API_URL}/users/profile`);
  return response.data;
};

export const updateUserProfile = async (
  profile: UserProfile
): Promise<UserProfile> => {
  const response = await axios.put(`${API_URL}/users/profile`, profile);
  return response.data;
};
