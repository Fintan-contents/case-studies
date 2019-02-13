package kanade.back.service;

import kanade.back.common.InsertData;
import kanade.back.dto.*;
import org.dbunit.Assertion;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.csv.CsvDataSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import java.io.File;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QuestionServiceTest {

    /** テスト対象クラス */
    @Autowired
    private QuestionService service;

    /** DB接続用 */
    @Autowired
    private DataSource dataSource;

    /** データ投入 */
    @Autowired
    private InsertData insertData;

    /** DBUnit用のDB接続 */
    private IDatabaseConnection connection;

    @Before
    public void setUp() throws Exception {
        System.out.println("Setup");
        connection = new DatabaseConnection(dataSource.getConnection());
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Teardown");
        connection.close();
    }

    @Test
    public void 質問テーブルのデータが全件取得できること() {
        try {
            insertData.insertData("questionList", connection);
        } catch (Exception e) {
            fail("データ投入失敗\n" + e.getMessage());
        }

        assertThat(service.getQuestionList().size(), is(3));
    }

    @Test
    public void 質問テーブルの1レコードの各列のデータが正常に取得できること() {
        try {
            insertData.insertData("questionList",connection);
        } catch (Exception e) {
            fail("データ投入失敗\n" + e.getMessage());
        }

        QuestionDto questionSearchResultDto = service.getQuestionList().get(0);
        assertThat(questionSearchResultDto.getTitle(), is("質問012345678901234567890123456789012345678901234567890123456789"));
        assertThat(questionSearchResultDto.getContent(), is("テスト用質問本文ですテスト用質問本文ですテスト用質問本文ですテスト用質問本文ですテスト用質問本文ですテスト用質問本文ですテスト用質問本文ですテスト用質問本文ですテスト用質問本文ですテスト用質問本文ですテスト用質問本文ですテスト用質問本文ですテスト用質問本文ですテスト用質問本文ですテスト用質問本文ですテスト用質問本文です"));
        assertThat(questionSearchResultDto.getCreateTime(), is("2018-11-21 11:00:00"));
        assertThat(questionSearchResultDto.getFirstName(), is("taro"));
        assertThat(questionSearchResultDto.getLastName(), is("yamada"));
        assertThat(questionSearchResultDto.getImageName(), is("https://s3-ap-northeast-1.amazonaws.com/kanade-dev/image/image001.png"));
        assertThat(questionSearchResultDto.getQuestionId(), is(3));
    }


    @Test
    public void 質問回答画面表示情報が正常に取得できること() {
        try {
            insertData.insertData("questionAnswer",connection);
        } catch (Exception e) {
            fail("データ投入失敗\n" + e.getMessage());
        }

        QuestionAnswerSearchResultDto actual = service.getQuestionAnswer(1);

        // 質問
        assertThat(actual.getTitle(), is("質問1"));
        assertThat(actual.getContent(), is("テスト用の質問本文です。"));
        assertThat(actual.getCreateTime(), is("2018-11-19 11:00:00"));
        assertThat(actual.getFirstName(), is("taro"));
        assertThat(actual.getLastName(), is("yamada"));
        assertThat(actual.getImageName(), is("https://s3-ap-northeast-1.amazonaws.com/kanade-dev/image/image001.png"));

        // 質問に対するコメント
        List<CommentDto> commentList = actual.getCommentList();
        CommentDto comment1 = commentList.get(0);
        CommentDto comment2 = commentList.get(1);
        assertThat(comment1.getContent(), is("質問に対するコメント１です。"));
        assertThat(comment1.getLastName(), is("yamada"));
        assertThat(comment1.getFirstName(), is("taro"));
        assertThat(comment1.getCreateTime(), is("2018-11-19 11:00:00"));
        assertThat(comment2.getContent(), is("質問に対するコメント２です。"));
        assertThat(comment2.getLastName(), is("sato"));
        assertThat(comment2.getFirstName(), is("hanako"));
        assertThat(comment2.getCreateTime(), is("2018-11-20 11:00:00"));

        // 回答
        List<AnswerWithCommentDto> answerWithCommentDtoList = actual.getAnswerWithCommentDtoList();
        AnswerWithCommentDto answerWithCommentDto1 = answerWithCommentDtoList.get(0);
        AnswerWithCommentDto answerWithCommentDto2 = answerWithCommentDtoList.get(1);
        assertThat(answerWithCommentDto1.getContent(), is("テスト用の回答本文１です。"));
        assertThat(answerWithCommentDto1.getLastName(), is("yamada"));
        assertThat(answerWithCommentDto1.getFirstName(), is("taro"));
        assertThat(answerWithCommentDto1.getCreateTime(), is("2018-11-19 11:00:00"));
        assertThat(answerWithCommentDto1.getImageName(), is("https://s3-ap-northeast-1.amazonaws.com/kanade-dev/image/image001.png"));
        assertThat(answerWithCommentDto2.getContent(), is("テスト用の回答本文２です。"));
        assertThat(answerWithCommentDto2.getLastName(), is("sato"));
        assertThat(answerWithCommentDto2.getFirstName(), is("hanako"));
        assertThat(answerWithCommentDto2.getCreateTime(), is("2018-11-20 11:00:00"));
        assertThat(answerWithCommentDto2.getImageName(), is("https://s3-ap-northeast-1.amazonaws.com/kanade-dev/image/image002.png"));

        // 回答１に対するコメント
        List<CommentDto> answerCommentList = answerWithCommentDtoList.get(0).getCommentList();
        CommentDto commentForAnswer1 = answerCommentList.get(0);
        CommentDto commentForAnswer2 = answerCommentList.get(1);
        assertThat(commentForAnswer1.getContent(), is("回答に対するコメント１です。"));
        assertThat(commentForAnswer1.getLastName(), is("yamada"));
        assertThat(commentForAnswer1.getFirstName(), is("taro"));
        assertThat(commentForAnswer1.getCreateTime(), is("2018-11-19 11:00:00"));
        assertThat(commentForAnswer2.getContent(), is("回答に対するコメント２です。"));
        assertThat(commentForAnswer2.getLastName(), is("sato"));
        assertThat(commentForAnswer2.getFirstName(), is("hanako"));
        assertThat(commentForAnswer2.getCreateTime(), is("2018-11-20 11:00:00"));

    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void 表示対象の質問が存在しない場合エラーとなること() {
        try {
            insertData.insertData("questionAnswer",connection);
        } catch (Exception e) {
            fail("データ投入失敗\n" + e.getMessage());
        }

        QuestionAnswerSearchResultDto actual = service.getQuestionAnswer(10);
    }

    @Test
    public void 質問を１件登録() throws Exception{
        try {
            insertData.insertData("createQuestion",connection);
            connection.getConnection().createStatement().executeQuery("select setval ('question_id', 1, false);");
        } catch (Exception e) {
            fail("データ投入失敗\n" + e.getMessage());
        }

        QuestionCreateDto dto = new QuestionCreateDto();
        dto.setTitle("title");
        dto.setContent("content");
        int userId = 1;
        int actualQuestionId = service.createQuestion(dto, userId);

        assertThat(actualQuestionId, is(1));

        try {
            IDataSet expectedDataSet = new CsvDataSet(new File("src/test/resources/expectData/createQuestion"));
            ITable expectedTable = expectedDataSet.getTable("QUESTION");

            IDataSet databaseDataSet = connection.createDataSet();
            ITable actualTable = databaseDataSet.getTable("QUESTION");

            Assertion.assertEquals(expectedTable, actualTable);

        } catch (Exception e) {
            fail(e.getMessage());
        }

    }
}
