FROM node:20.5.0-alpine3.18 as build-stage
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
# Incrementar el límite de memoria a 8192 MB
ENV NODE_OPTIONS="--max_old_space_size=8192"
RUN npm run build

FROM nginx:stable-alpine
# Copiar los activos construidos desde la etapa de construcción
COPY --from=build-stage /app/build /usr/share/nginx/html
