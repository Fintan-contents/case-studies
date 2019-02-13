package kanade.back.model;

import org.seasar.doma.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 質問
 *
 * @author Ko
 * @since 1.0
 */
@Entity
@Table(name = "Question")
public class Question implements Serializable {

    /** 質問ID */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequence = "QUESTION_ID")
    private Integer questionId;

    /** 質問タイトル */
    private String title;

    /** 質問本文 */
    private String content;

    /** 作成日時 */
    private LocalDateTime createTime;

    /** 更新日時 */
    private LocalDateTime updateTime;

    /** 作成者ID */
    private Integer createUserId;

    /**
     * 質問IDを返します。
     *
     * @return 質問ID
     */
    public Integer getQuestionId() {
        return questionId;
    }

    /**
     * 質問IDを設定します。
     *
     * @param questionId 質問ID
     */
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    /**
     * 質問タイトルを返します。
     *
     * @return 質問タイトル
     */
    public String getTitle() {
        return title;
    }

    /**
     * 質問タイトルを設定します。
     *
     * @param title 質問タイトル
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 質問内容を返します。
     *
     * @return 質問内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 質問内容を設定します。
     *
     * @param content 質問内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 作成日時を返します。
     *
     * @return 作成日時
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * 作成日時を設定します。
     *
     * @param createTime 作成日時
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     *更新日時を返します。
     *
     * @return 更新日時
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新日時を設定します。
     *
     * @param updateTime 更新日時
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 作成者IDを返します。
     *
     * @return 作成者ID
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * 作成者IDを設定します。
     *
     * @param createUserId 作成者ID
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }


}
