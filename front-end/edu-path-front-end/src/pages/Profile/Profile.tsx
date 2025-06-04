import React, { useState, useEffect } from "react";
import type { UserProfile } from "../../types/user";
import ProfileForm from "../../components/Profile/ProfileForm";
import {
  getCurrentUserProfile,
  updateUserProfileById,
} from "../../services/userService";

export default function Profile() {
  const [profile, setProfile] = useState<UserProfile | null>(null);
  const [isLoading, setIsLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    loadProfile();
  }, []);

  const loadProfile = async () => {
    try {
      setIsLoading(true);
      const data = await getCurrentUserProfile();
      if (data) {
        setProfile(data);
      } else {
        setError("Perfil não encontrado.");
      }
    } catch (err) {
      setError("Erro ao carregar perfil. Tente novamente mais tarde.");
    } finally {
      setIsLoading(false);
    }
  };

  const handleUpdateProfile = async (data: UserProfile) => {
    try {
      const userId = localStorage.getItem("userId");
      if (!userId) {
        setError("Usuário não autenticado.");
        return;
      }
      const updatedProfile = await updateUserProfileById(userId, data);
      setProfile(updatedProfile);
      alert("Perfil atualizado com sucesso!");
    } catch (err) {
      setError("Erro ao atualizar perfil. Tente novamente mais tarde.");
    }
  };

  if (isLoading) {
    return (
      <div className="flex justify-center items-center h-[50vh]">
        <div className="text-primary-600">Carregando...</div>
      </div>
    );
  }

  if (error) {
    return (
      <div className="flex justify-center items-center h-[50vh]">
        <div className="text-red-600">{error}</div>
      </div>
    );
  }

  return (
    <div className="max-w-4xl mx-auto p-4 sm:p-6 lg:p-8">
      <h1 className="text-3xl font-bold text-gray-900 dark:text-white mb-8">
        Perfil
      </h1>
      {profile && (
        <ProfileForm initialData={profile} onSubmit={handleUpdateProfile} />
      )}
    </div>
  );
}
