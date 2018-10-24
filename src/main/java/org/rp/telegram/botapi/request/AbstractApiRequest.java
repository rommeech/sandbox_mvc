package org.rp.telegram.botapi.request;

import org.rp.telegram.botapi.response.AbstractApiResponse;
import java.io.Serializable;

public abstract class AbstractApiRequest  implements Serializable {
    private static final long serialVersionUID = 7804600306168520303L;
    public abstract AbstractApiResponse doRequest(String token) throws RequestException;
}
