package net.sitecore.android.sdk.api.model;

import com.android.volley.Response;

import java.util.Map;

import net.sitecore.android.sdk.api.ScRequest;
/**
 * Class represents create item request.
 * @see UpdateItemFieldsRequest
 * @see DeleteItemsRequest
 * @see GetItemsRequest
 * @see ScRequest
 */
public class CreateItemRequest extends ScRequest<ItemsResponse> {

    /**
     * Creates request to create item with specified fields.
     * @param url item full url to update
     * @param bodyFields {@link Map} with {@link ScField#getName()}/{@link ScField#getId()} : {@link String} value entries
     * @param successListener success listener for request
     * @param errorListener error listener for request
     */
    public CreateItemRequest(String url, Map<String, String> bodyFields,
            Response.Listener<ItemsResponse> successListener, Response.ErrorListener errorListener) {
        super(Method.POST, url, ItemsResponse.class, successListener, errorListener);
        mBodyFields = bodyFields;
    }

}