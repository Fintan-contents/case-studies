SELECT
    an.answer_Id,
    an.content,
    an.create_time,
    an.question_id,
    up.last_name,
    up.first_name,
    up.image_name
FROM
    answer an
INNER JOIN
    user_profile up
ON
    an.create_user_id = up.user_id
WHERE
    an.question_id = /* questionId */1
ORDER BY
    an.create_time ASC
