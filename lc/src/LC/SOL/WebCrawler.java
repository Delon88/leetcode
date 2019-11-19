package LC.SOL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WebCrawler {
    class Solution {
        public List<String> crawl(String startUrl, HtmlParser htmlParser) {
            Set<String> v = new HashSet<>();
            List<String> ret = new ArrayList<>();
            dfs(gethostName(startUrl), startUrl, htmlParser, ret , v);
            return ret;
        }

        void dfs(String hostName, String curUrl, HtmlParser p, List<String> ret, Set<String> v ) {
            if ( v.contains(curUrl)) return;
            v.add(curUrl);
            ret.add(curUrl);
            for ( String next : p.getUrls(curUrl)) {
                if ( gethostName(next).equals(hostName)) dfs(hostName, next, p , ret , v);
            }
        }

        String gethostName(String url) {
            return url.split("/")[2];
        }
    }

    interface HtmlParser {
        public List<String> getUrls(String url);
    }
}
