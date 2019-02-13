package kanade.back.dto;

import org.seasar.doma.Entity;
import org.seasar.doma.jdbc.entity.NamingType;

/**
 * 回答検索結果格納用DTO
 *
 * @author Takahashi
 * @since 1.0
 */
@Entity
public class AnswerDto {
    /** 回答ID */
    private Integer answerId;

    /** 回答本文 */
    private String content;

    /** 作成日時 */
    private String createTime;

    /** 更新日時 */
    private String updateTime;

    /** 姓 */
    private String lastName;

    /** 名 */
    private String firstName;

    /** 質問ID */
    private Integer questionId;

    /** 画像 */
    private String imageName;

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
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 作成日時を設定します。
     *
     * @param createTime 作成日時
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     *更新日時を返します。
     *
     * @return 更新日時
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新日時を設定します。
     *
     * @param updateTime 更新日時
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 姓を返します。
     *
     * @return 姓
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 姓を設定します。
     *
     * @param lastName 姓
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 名を返します。
     *
     * @return 名
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 名を設定します。
     *
     * @param firstName 名
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    /**
     * アバター画像を返します。
     *
     * @return 画像
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * 画像を設定します。
     *
     * @param imageName 画像
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
