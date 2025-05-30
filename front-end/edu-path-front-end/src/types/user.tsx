export type UserProfile = {
  userId: string;
  name: string;
  bio: string;
  interestArea: string;
  experienceLevel: "BEGINNER" | "INTERMEDIATE" | "ADVANCED";
  profileImageUrl?: string;
  contactEmail: string;
};
