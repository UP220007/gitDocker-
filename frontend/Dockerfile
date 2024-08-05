FROM node:20.14.0 as build-stage
ENV NODE_OPTIONS="--max-old-space-size=4096"
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

FROM nginx:stable-alpine
# Copy built assets from build-stage
COPY --from=build-stage /app/build /usr/share/nginx/html