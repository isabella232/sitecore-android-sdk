package net.sitecore.android.sdk.api;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;

import com.android.volley.Request;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;

import net.sitecore.android.sdk.api.model.DeleteItemsResponse;
import net.sitecore.android.sdk.api.model.ItemsResponse;
import net.sitecore.android.sdk.api.model.ScItem;

/**
 * Interface for interaction with Sitecore Item Web API.
 * All requests to Sitecore Item Web API are built using instances of {@link ScApiSession}.
 */
public interface ScApiSession {
    /**
     * Creates {@link RequestBuilder} to build the {@link GetItemsRequest}.
     *
     * @param successListener Success result callback.
     * @param errorListener   Error result callback
     *
     * @return {@link RequestBuilder} to build the request.
     */
    public RequestBuilder readItemsRequest(Listener<ItemsResponse> successListener, ErrorListener errorListener);

    /**
     * Creates {@link GetItemsRequest} to load list of items with particular IDs.
     *
     * @param successListener Success result callback.
     * @param errorListener   Error result callback
     * @param itemIds         specifies the ids of the items.
     *
     * @return {@link GetItemsRequest}.
     */
    public RequestBuilder readItemsByIdsRequest(ArrayList<String> itemIds, Listener<ItemsResponse> successListener,
            ErrorListener errorListener);

    /**
     * Creates {@link RequestBuilder} to build the {@link CreateItemRequest}
     *
     * @param itemName        specifies the name of the item being created. It must be a valid Sitecore item name.
     * @param template        specifies the template that the new item is based on.
     *                        It either accepts the template ID or the relative template path.
     *                        For example, {@code "Sample/MyTemplate"}
     * @param successListener Success result callback.
     * @param errorListener   Error result callback
     *
     * @return {@link RequestBuilder} to build the request.
     */
    public RequestBuilder createItemRequest(String itemName, String template,
            Listener<ItemsResponse> successListener, ErrorListener errorListener);

    /**
     * Creates {@link RequestBuilder} to build the {@link CreateItemRequest}
     *
     * @param branchId        specifies the branch id that the new item is based on.
     * @param successListener Success result callback.
     * @param errorListener   Error result callback
     *
     * @return {@link RequestBuilder} to build the request.
     */
    public RequestBuilder createItemRequest(String branchId, Listener<ItemsResponse> successListener,
            ErrorListener errorListener);

    /**
     * Creates {@link RequestBuilder} to build the {@link UpdateItemFieldsRequest}.
     *
     * @param successListener Success result callback.
     * @param errorListener   Error result callback
     *
     * @return {@link RequestBuilder} to build the request.
     */
    public RequestBuilder editItemsRequest(Listener<ItemsResponse> successListener, ErrorListener errorListener);

    /**
     * Creates {@link RequestBuilder} to build the {@link DeleteItemsRequest}.
     *
     * @param successListener Success result callback.
     * @param errorListener   Error result callback
     *
     * @return {@link RequestBuilder} to build the request.
     */
    public RequestBuilder deleteItemsRequest(Listener<DeleteItemsResponse> successListener, ErrorListener errorListener);

    /**
     * Creates request to read items from default path (/-/item/v1/) to check result code.
     *
     * @param context  current context.
     * @param callback Is called after request is executed with {@code true} if request succeeded (200 <= code <= 300),
     *                 and {@code false} otherwise.
     */
    public Request checkCredentialsRequest(Context context, final Listener<Boolean> callback);

    /**
     * Creates {@link GetRenderingHtmlRequestBuilder} to build special request to load
     * html rendering of an item.
     *
     * @param renderingId     Id of needed rendering item.
     * @param itemId          Id of needed data source item.
     * @param successListener Success result callback.
     * @param errorListener   Error result callback
     */
    public GetRenderingHtmlRequestBuilder getRenderingHtmlRequest(String renderingId, String itemId,
            Listener<String> successListener, ErrorListener errorListener);

    /**
     * Creates {@link UploadMediaRequestOptions} that describe image upload request.
     * Afterwards {@link UploadMediaService#startUpload} or {@link UploadMediaService#newUploadIntent} must be used.
     *
     * @param itemPath      Media folder path to upload media to.
     * @param itemName      Name of the media item.
     * @param mediaFilePath any of "content://", "http://", "file://"
     *
     * @return {@link UploadMediaRequestOptions} that describe image upload request.
     */
    public UploadMediaRequestOptions uploadMedia(String itemPath, String itemName, String mediaFilePath);

    public DeleteItemsRequest deleteItem(ScItem item, Listener<DeleteItemsResponse> successListener,
            ErrorListener errorListener);

    public GetItemsRequest getItemChildren(ScItem parentItem, Listener<ItemsResponse> successListener,
            ErrorListener errorListener);

    //TODO: find practical usage.
    public ScRequest updateItemFields(ScItem item, HashMap<String, String> fields,
            Listener<ItemsResponse> successListener, ErrorListener errorListener);

    /** @return Backend url with port. */
    public String getBaseUrl();

    public boolean isAnonymous();

    /** @return {@code true} if requests should cache all responses. {@code false} by default. */
    public boolean shouldCache();

    /** Sets default caching value for all built requests. Setting this value in request have higher priority. */
    public void setShouldCache(boolean shouldCache);

    /**
     * Creates encoded name for auth http header.
     * Returns {@code null} when {@link #isAnonymous()} is true;
     */
    String createEncodedName();

    /**
     * Creates encoded password for auth http header.
     * Returns {@code null} when {@link #isAnonymous()} is true;
     */
    String createEncodedPassword();

}
