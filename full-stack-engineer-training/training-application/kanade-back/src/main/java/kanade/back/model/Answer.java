package kanade.back.model;

import org.seasar.doma.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 回答
 *
 * @author Takahashi
 * @since 1.0
 */
@Entity
@Table(name = "Answer")
public class Answer implements Serializable {

    /** 回答ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(sequence = "ANSWER_ID")
    private Integer answerId;

    /** 回答本文 */
    private String content;

    /** 作成日時 */
    private Date createTime;

    /** 更新日時 */
    private Date updateTime;

    /** 作成者ID */
    private Integer createUserId;

    /** 質問ID */
    private Integer questionId;

    /**
     * 回答IDを返します。
     *
     * @return 回答ID
     */
    public Integer getAnswerId() {
        return answerId;
    }

    /**
     * 回答IDを設定します。
     *
     * @param answerId 回答ID
     */
    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    /**
     * 回答内容を返します。
     *
     * @return 回答内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 回答内容を設定します。
     *
     * @param content 回答内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 作成日時を返します。
     *
     * @return 作成日時
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 作成日時を設定します。
     *
     * @param createTime 作成日時
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *更新日時を返します。
     *
     * @return 更新日時
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新日時を設定します。
     *
     * @param updateTime 更新日時
     */
    public void setUpdateTime(Date updateTime) {
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
}
