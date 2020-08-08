* Installed ESLint 5 as the version of Webstorm used for development has a bug with version 6.
* Added `SKIP_PREFLIGHT_CHECK=true` because `react-scripts` need ESLint 6 and we manually installed ESLint 5.
* `npx` is a npm package runner (x probably stands for eXecute). The typical use is to download and run a package 
temporarily or for trials. create-react-app is an npm package that is expected to be run only once in a project's 
lifecycle. Hence, it is preferred to use npx to install and run it in a single step.
* Babel will turn your ES6+ code into ES5 friendly code, so you can start using it right now without waiting for browser 
support
* Webpack: A bundler for javascript
* `create-react-app` will automatically setup babel and webpack for you.
* The value of `NODE_ENV` is set automatically to development (when using `npm start`), test (when using `npm test`) or 
production (when using `npm build`).