#sql("word")
SELECT
    *
FROM
    sensitive_words_list
WHERE
        1 = 1
    #if(status != null && status != "")
        AND `status` = 1;
    #end
#end