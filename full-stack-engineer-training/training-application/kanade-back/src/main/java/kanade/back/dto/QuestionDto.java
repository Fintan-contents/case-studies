package kanade.back.dto;

import org.seasar.doma.Entity;
import org.seasar.doma.jdbc.entity.NamingType;

/**
 * 質問リスト検索結果格納用DTO
 *
 * @author Ko
 * @since 1.0
 */
@Entity
public class QuestionDto {
    /** 姓 */
    private String lastName;

    /** 名 */
    private String firstName;

    /** 画像 */
    private String imageName;

    /** 質問ID */
    private Integer questionId;

    /** 質問タイトル */
    private String title;

    /** 質問本文 */
    private String content;

    /** 作成日時 */
    private String createTime;

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

}
