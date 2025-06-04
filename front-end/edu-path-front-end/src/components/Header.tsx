import { useState } from "react";
import { Link } from "react-router-dom";

export function Header() {
  const [isMenuOpen, setIsMenuOpen] = useState(false);

  return (
    <header className="bg-primary-100 dark:bg-primary-900 shadow-md">
      <nav className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div className="flex justify-between h-16">
          <div className="flex items-center">
            <Link
              to="/"
              className="text-2xl font-bold text-primary-900 dark:text-primary-100"
            >
              EduPath
            </Link>
          </div>

          {/* Desktop Menu */}
          <div className="hidden md:flex items-center space-x-4">
            <Link
              to="/login"
              className="text-primary-800 dark:text-primary-200 hover:text-primary-600 dark:hover:text-primary-400"
            >
              Login
            </Link>
            <Link
              to="/courses"
              className="text-primary-800 dark:text-primary-200 hover:text-primary-600 dark:hover:text-primary-400"
            >
              Cursos
            </Link>
            <Link
              to="/profile"
              className="text-primary-800 dark:text-primary-200 hover:text-primary-600 dark:hover:text-primary-400"
            >
              Perfil
            </Link>
          </div>

          {/* Mobile Menu Button */}
          <div className="md:hidden flex items-center">
            <button
              onClick={() => setIsMenuOpen(!isMenuOpen)}
              className="text-primary-800 dark:text-primary-200"
            >
              <svg
                className="h-6 w-6"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
              >
                <path
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  strokeWidth={2}
                  d={
                    isMenuOpen
                      ? "M6 18L18 6M6 6l12 12"
                      : "M4 6h16M4 12h16M4 18h16"
                  }
                />
              </svg>
            </button>
          </div>
        </div>

        {/* Mobile Menu */}
        {isMenuOpen && (
          <div className="md:hidden">
            <div className="px-2 pt-2 pb-3 space-y-1">
              <Link
                to="/courses"
                className="block text-primary-800 dark:text-primary-200 hover:text-primary-600 dark:hover:text-primary-400"
              >
                Cursos
              </Link>
              <Link
                to="/profile"
                className="block text-primary-800 dark:text-primary-200 hover:text-primary-600 dark:hover:text-primary-400"
              >
                Perfil
              </Link>
            </div>
          </div>
        )}
      </nav>
    </header>
  );
}
