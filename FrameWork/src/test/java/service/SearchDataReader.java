package service;

public class SearchDataReader {

    private static final String TEST_DATA_QUERY = "testdata.search.tvQuery";

    public static String getSearchQuery() {
        return TestDataReader.getTestData(TEST_DATA_QUERY);
    }
}
