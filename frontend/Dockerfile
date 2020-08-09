FROM node:14.7.0-alpine3.12 as build
WORKDIR /app
ENV PATH /app/node_modules/.bin:$PATH
COPY package.json ./
COPY package-lock.json ./
RUN npm ci --silent
COPY . ./
ARG REACT_APP_API_URL
ENV REACT_APP_API_URL $REACT_APP_API_URL
RUN npm run build

FROM nginx:1.19.1-alpine
COPY --from=build /app/build /usr/share/nginx/html
RUN rm /etc/nginx/conf.d/default.conf
COPY nginx/nginx.conf /etc/nginx/conf.d/
CMD ["nginx", "-g", "daemon off;"]