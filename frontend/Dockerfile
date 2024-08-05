FROM node:lts as build-stage
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
# Incrementa el límite de memoria
RUN NODE_OPTIONS="--max_old_space_size=4096" npm run build

FROM nginx:stable-alpine
# Copy built assets from build-stage
COPY --from=build-stage /app/build /usr/share/nginx/html
