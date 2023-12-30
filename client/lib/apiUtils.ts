import { ENDPOINTS, EndpointKey } from './apiEndpoints';

const sendRequest = async (method: string, endpointKey: EndpointKey, data = {}, id: string = '') => {
  const endpoint = ENDPOINTS[endpointKey];

  if (!endpoint) {
    throw new Error(`Endpoint key "${endpointKey}" not found`);
  }

  const headers = {
    'Content-Type': 'application/json',
  };

  const options = {
    method,
    headers,
    body: data ? JSON.stringify(data) : null,
  };

  try {
    var response:any
    
    if(method == "PUT"){
      console.log("AQUIIII: ",`${endpoint}/${id}`)
       response = await fetch(`${endpoint}/${id}`, options);

    } else{
       response = await fetch(endpoint, options);

    }

    if (!response.ok) {
      // If there's an error, log the message and throw the error
      const errorData = await response.json();
      console.error("Error: ", errorData.message);
      throw new Error(`HTTP error! Status: ${response.status}`);
    }

    // If the response is okay, read the response data
    const responseData = await response.json();
    return responseData;
  } catch (error:any) {
    // Handle any other errors
    console.error('Request failed:', error.message);
    throw error;
  }
};

export default sendRequest;
