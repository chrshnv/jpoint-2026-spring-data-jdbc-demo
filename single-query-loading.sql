SELECT
  CASE
    WHEN rn_post_1 = rn THEN c_title_4
    ELSE NULL
  END AS c_title_4,
  CASE
    WHEN rn_post_1 = rn THEN c_content_5
    ELSE NULL
  END AS c_content_5,
  CASE
    WHEN rn_comment_7 = rn THEN c_content_11
    ELSE NULL
  END AS c_content_11,
  key_comment_10,
  c_id_3
FROM
  (
    SELECT
      c_title_4,
      c_content_5,
      rn_post_1,
      c_id_3,
      c_content_11,
      rn_comment_7,
      br_comment_9,
      key_comment_10,
      GREATEST(COALESCE(rn_post_1, 1), COALESCE(rn_comment_7, 1)) AS rn
    FROM
      (
        SELECT
          1 AS rn_post_1,
          1 AS rc_post_2,
          "post"."id" AS c_id_3,
          "post"."title" AS c_title_4,
          "post"."content" AS c_content_5
        FROM
          "post"
      ) t_post_6
      LEFT OUTER JOIN (
        SELECT
          ROW_NUMBER() OVER (
            PARTITION BY
              "comment"."post_id"
            ORDER BY
              "comment"."post_id"
          ) AS rn_comment_7,
          COUNT(*) OVER (
            PARTITION BY
              "comment"."post_id"
          ) AS rc_comment_8,
          "comment"."post_id" AS br_comment_9,
          ROW_NUMBER() OVER (
            PARTITION BY
              "comment"."post_id"
            ORDER BY
              "comment"."post_id"
          ) AS key_comment_10,
          "comment"."content" AS c_content_11
        FROM
          "comment"
      ) t_comment_12 ON c_id_3 = br_comment_9
  ) main
ORDER BY
  c_id_3,
  rn
