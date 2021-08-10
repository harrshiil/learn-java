import { environment } from './../../environments/environment';

const API_URL = environment.HOST_URL;

export const CONSTANTS = {
    ENDPOINTS: {
        LOGIN: API_URL + 'api/web/authenticate'
    },
    TOASTER: {
        theme: 'bootstrap',
        toasterTimeout: 5000
    },
    MESSAGES: {
        UNAUTHORIZED: 'Access Denied',
        SERVER_ERROR: 'There was a problem requesting data',
        SUCCESS: 'Your request has been sent successfully',
        SOMETHING_WENT_WRONG: 'Something Went Wrong please contact Press Administrator.',
        ACTIVATE_SUCCESS: 'Your Press account is activated. Now you can login from iOS or Android App.'
    }
};
