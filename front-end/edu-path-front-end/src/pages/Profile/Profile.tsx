import React, { useState, useEffect } from "react";
import type { UserProfile } from "../../types/user";
import ProfileForm from "../../components/Profile/ProfileForm";

export default function Profile() {
  const [profile, setProfile] = useState<UserProfile | null>(null);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    // Simulando carregamento do perfil
    setTimeout(() => {
      setProfile({
        userId: "1",
        name: "John Doe",
        bio: "",
        interestArea: "Frontend",
        experienceLevel: "BEGINNER",
        contactEmail: "john@example.com",
      });
      setIsLoading(false);
    }, 1000);
  }, []);

  const handleUpdateProfile = (data: UserProfile) => {
    console.log("Profile updated:", data);
    setProfile(data);
  };

  if (isLoading) {
    return (
      <div className="flex justify-center items-center h-[50vh]">
        <div className="text-primary-600">Carregando...</div>
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
