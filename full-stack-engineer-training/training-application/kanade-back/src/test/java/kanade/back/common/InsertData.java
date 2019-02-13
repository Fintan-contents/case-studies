package kanade.back.common;


import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.csv.CsvDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * テスト用データの投入クラス
 *
 * @author Ko
 * @since 1.0
 */
@Component
public class InsertData {

    /** セットアップ用設定ファイル格納先 */
    private String SETUP_PARENT_DIR_PATH = "src/test/resources/setupData/";

    /**
     * テスト用データの投入。
     * 指定したディレクトリ直下のtable-ordering.txtに記載のあるテーブルをtruncate後にinsertする。
     *
     * @param dirName table-ordering.txtがあるディレクトリ名({@code SETUP_PARENT_DIR_PATH}より後を指定する。)
     */
    public void insertData(String dirName, IDatabaseConnection connection) throws Exception {
        IDataSet iDataSet = new CsvDataSet(new File(SETUP_PARENT_DIR_PATH, dirName));
        DatabaseOperation.CLEAN_INSERT.execute(connection, iDataSet);
    }
}
