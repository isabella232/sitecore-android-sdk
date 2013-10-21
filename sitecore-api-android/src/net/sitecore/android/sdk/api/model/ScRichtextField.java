package net.sitecore.android.sdk.api.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sitecore.android.sdk.api.ScApiSession;

/** This class represents Rich Text field type of Sitecore */
public class ScRichtextField extends ScField {
    private static Pattern sPattern = Pattern.compile("<img.*?src=(\"|')((~/media).*?)(\"|').*?(/>|</img>)");
    private String mHtmlText;

    protected ScRichtextField(String name, String id, Type type, String rawValue) {
        super(name, id, type, rawValue);
    }

    /**
     * Creates html in which all image urls are replaced with full image urls.
     *
     * @param apiSession session to build urls.
     *
     * @return {@link String} modified html.
     */
    public String getHtmlText(ScApiSession apiSession) {
        if (mHtmlText == null) {
            Matcher matcher = sPattern.matcher(getRawValue());
            StringBuffer sb = new StringBuffer();
            while (matcher.find()) {
                String url = matcher.group(2);
                matcher.appendReplacement(sb,
                        matcher.group(0).replace(url,
                                url.replace("~", apiSession.getBaseUrl() + "/~")));
            }
            matcher.appendTail(sb);
            mHtmlText = sb.toString();
        }
        return mHtmlText;
    }
}
