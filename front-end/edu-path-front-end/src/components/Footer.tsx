import { Link } from "react-router-dom";

export function Footer() {
  return (
    <footer className="bg-primary-100 dark:bg-primary-900 mt-auto">
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-8">
        <div className="grid grid-cols-1 md:grid-cols-3 gap-8">
          <div>
            <h3 className="text-lg font-semibold text-primary-900 dark:text-primary-100 mb-4">
              EduPath
            </h3>
            <p className="text-primary-700 dark:text-primary-300">
              Sua jornada educacional começa aqui
            </p>
          </div>

          <div>
            <h4 className="text-lg font-semibold text-primary-900 dark:text-primary-100 mb-4">
              Links Úteis
            </h4>
            <ul className="space-y-2">
              <li>
                <Link
                  to="/about"
                  className="text-primary-700 dark:text-primary-300 hover:text-primary-600 dark:hover:text-primary-400"
                >
                  Sobre Nós
                </Link>
              </li>
              <li>
                <Link
                  to="/contact"
                  className="text-primary-700 dark:text-primary-300 hover:text-primary-600 dark:hover:text-primary-400"
                >
                  Contato
                </Link>
              </li>
            </ul>
          </div>

          <div>
            <h4 className="text-lg font-semibold text-primary-900 dark:text-primary-100 mb-4">
              Redes Sociais
            </h4>
            <div className="flex space-x-4">
              <a
                href="#"
                className="text-primary-700 dark:text-primary-300 hover:text-primary-600 dark:hover:text-primary-400"
              >
                <span className="sr-only">Facebook</span>
                <svg
                  className="h-6 w-6"
                  fill="currentColor"
                  viewBox="0 0 24 24"
                >
                  <path d="M18.77,7.46H14.5v-1.9c0-.9.6-1.1,1-1.1h3V.5L14.51.5C10.41.5,9.51,3,9.51,5.3V7.46H6.5v4h3v12h5v-12h3.85l.42-4Z" />
                </svg>
              </a>
              <a
                href="#"
                className="text-primary-700 dark:text-primary-300 hover:text-primary-600 dark:hover:text-primary-400"
              >
                <span className="sr-only">Instagram</span>
                <svg
                  className="h-6 w-6"
                  fill="currentColor"
                  viewBox="0 0 24 24"
                >
                  <path d="M12,2.16c3.2,0,3.58,0,4.85.07,3.25.15,4.77,1.69,4.92,4.92.06,1.27.07,1.65.07,4.85s0,3.58-.07,4.85c-.15,3.23-1.69,4.77-4.92,4.92-1.27.06-1.65.07-4.85.07s-3.58,0-4.85-.07c-3.25-.15-4.77-1.69-4.92-4.92-.06-1.27-.07-1.65-.07-4.85s0-3.58.07-4.85C2.38,3.92,3.92,2.38,7.15,2.23,8.42,2.18,8.8,2.16,12,2.16ZM12,0C8.74,0,8.33,0,7.05.07c-4.35.2-6.78,2.62-7,7C0,8.33,0,8.74,0,12s0,3.67.07,4.95c.2,4.35,2.62,6.78,7,7C8.33,24,8.74,24,12,24s3.67,0,4.95-.07c4.35-.2,6.78-2.62,7-7C24,15.67,24,15.26,24,12s0-3.67-.07-4.95c-.2-4.35-2.62-6.78-7-7C15.67,0,15.26,0,12,0Zm0,5.84A6.16,6.16,0,1,0,18.16,12,6.16,6.16,0,0,0,12,5.84ZM12,16a4,4,0,1,1,4-4A4,4,0,0,1,12,16ZM18.41,4.15a1.44,1.44,0,1,0,1.44,1.44A1.44,1.44,0,0,0,18.41,4.15Z" />
                </svg>
              </a>
            </div>
          </div>
        </div>

        <div className="mt-8 border-t border-primary-200 dark:border-primary-800 pt-8">
          <p className="text-center text-primary-700 dark:text-primary-300">
            © {new Date().getFullYear()} EduPath. Todos os direitos reservados.
          </p>
        </div>
      </div>
    </footer>
  );
}
