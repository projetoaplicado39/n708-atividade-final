import React, { useState } from "react";
import type { UserProfile } from "../../types/user";

interface ProfileFormProps {
  initialData: UserProfile;
  onSubmit: (data: UserProfile) => void;
}

export default function ProfileForm({
  initialData,
  onSubmit,
}: ProfileFormProps) {
  const [formData, setFormData] = useState(initialData);
  const [isSubmitting, setIsSubmitting] = useState(false);

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setIsSubmitting(true);

    try {
      await onSubmit(formData);
    } finally {
      setIsSubmitting(false);
    }
  };

  const handleChange = (
    e: React.ChangeEvent<
      HTMLInputElement | HTMLTextAreaElement | HTMLSelectElement
    >
  ) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  return (
    <form onSubmit={handleSubmit} className="space-y-6">
      <div>
        <label
          htmlFor="name"
          className="block text-sm font-medium text-gray-700 dark:text-gray-200"
        >
          Nome
        </label>
        <input
          type="text"
          id="name"
          name="name"
          value={formData.name}
          onChange={handleChange}
          required
          className="mt-1 block w-full rounded-md border-gray-300 shadow-sm 
                     focus:border-primary-500 focus:ring-primary-500 
                     dark:bg-gray-700 dark:border-gray-600 dark:text-white"
        />
      </div>

      <div>
        <label
          htmlFor="bio"
          className="block text-sm font-medium text-gray-700 dark:text-gray-200"
        >
          Bio
        </label>
        <textarea
          id="bio"
          name="bio"
          value={formData.bio}
          onChange={handleChange}
          rows={4}
          className="mt-1 block w-full rounded-md border-gray-300 shadow-sm 
                     focus:border-primary-500 focus:ring-primary-500 
                     dark:bg-gray-700 dark:border-gray-600 dark:text-white"
        />
      </div>

      <div>
        <label
          htmlFor="interestArea"
          className="block text-sm font-medium text-gray-700 dark:text-gray-200"
        >
          Área de Interesse
        </label>
        <select
          id="interestArea"
          name="interestArea"
          value={formData.interestArea}
          onChange={handleChange}
          required
          className="mt-1 block w-full rounded-md border-gray-300 shadow-sm 
                     focus:border-primary-500 focus:ring-primary-500 
                     dark:bg-gray-700 dark:border-gray-600 dark:text-white"
        >
          <option value="Frontend">Frontend</option>
          <option value="Backend">Backend</option>
          <option value="FullStack">FullStack</option>
          <option value="Mobile">Mobile</option>
        </select>
      </div>

      <div>
        <label
          htmlFor="experienceLevel"
          className="block text-sm font-medium text-gray-700 dark:text-gray-200"
        >
          Nível de Experiência
        </label>
        <select
          id="experienceLevel"
          name="experienceLevel"
          value={formData.experienceLevel}
          onChange={handleChange}
          required
          className="mt-1 block w-full rounded-md border-gray-300 shadow-sm 
                     focus:border-primary-500 focus:ring-primary-500 
                     dark:bg-gray-700 dark:border-gray-600 dark:text-white"
        >
          <option value="BEGINNER">Iniciante</option>
          <option value="INTERMEDIATE">Intermediário</option>
          <option value="ADVANCED">Avançado</option>
        </select>
      </div>

      <div>
        <label
          htmlFor="contactEmail"
          className="block text-sm font-medium text-gray-700 dark:text-gray-200"
        >
          Email de Contato
        </label>
        <input
          type="email"
          id="contactEmail"
          name="contactEmail"
          value={formData.contactEmail}
          onChange={handleChange}
          required
          className="mt-1 block w-full rounded-md border-gray-300 shadow-sm 
                     focus:border-primary-500 focus:ring-primary-500 
                     dark:bg-gray-700 dark:border-gray-600 dark:text-white"
        />
      </div>

      <button
        type="submit"
        disabled={isSubmitting}
        className="w-full flex justify-center py-2 px-4 border border-transparent 
                   rounded-md shadow-sm text-sm font-medium text-white 
                   bg-primary-600 hover:bg-primary-700 focus:outline-none 
                   focus:ring-2 focus:ring-offset-2 focus:ring-primary-500 
                   disabled:opacity-50 disabled:cursor-not-allowed"
      >
        {isSubmitting ? "Salvando..." : "Salvar Alterações"}
      </button>
    </form>
  );
}
