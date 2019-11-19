package LC.SOL;

import java.util.List;

public class WebCrawlerMultithreaded {
    interface HtmlParser {
        public List<String> getUrls(String url);
    }

    class Solution {
        public List<String> crawl(String startUrl, HtmlParser htmlParser) {

        }
    }
}
