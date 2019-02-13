package kanade.back.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 質問投稿内容格納用DTO
 *
 * @author Takahashi
 * @since 1.0
 */
public class QuestionCreateDto {

    @NotBlank(message = "タイトルを入力してください。")
    @Size(max = 300, message = "タイトルは300文字以下で入力してください。")
    private String title;

    @NotBlank(message = "本文を入力してください。")
    @Size(max = 10000, message = "本文は10000文字以下で入力してください。")
    private String content;

    /**
     * タイトルを取得します
     * @return タイトル
     */
    public String getTitle() {
        return title;
    }

    /**
     * タイトルを設定します
     * @param title タイトル
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 本文を取得します
     * @return 本文
     */
    public String getContent() {
        return content;
    }

    /**
     * 本文を設定します
     * @param content 本文
     */
    public void setContent(String content) {
        this.content = content;
    }
}
