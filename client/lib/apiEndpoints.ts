const BaseUrl = process.env.API_BASE_URL
export const ENDPOINTS = {
  POSTS: `${BaseUrl}/posts`,
  USERS: `${BaseUrl}/api/user`,
  // Add more endpoints
};

export type EndpointKey = keyof typeof ENDPOINTS;