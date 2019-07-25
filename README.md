# Similarity Modellings over Stackoverflow
  The main function of this project is finding similar questions in Stackoverflow to a new question that you want to ask. The aim is when a user want to ask a new question to stackoverflow, we're going to find and show similar questions which are sorted by particular features and prevent the user from duplication or time waste. 
  
  Implementation Language: Python3
  Technologies: Google BigQuery, Google Colab
  We used 2 different main algorithms in implementations:
  1-Shingling-Minhashing-Locality Sentive Hashing
  2-Term Frequence-Inverse Document Frequence

Usage guideline: 
  1-Go to Google's BigQuery and open find stackoverflow from datasets.
  2-Type the following query(Dates or limits are up to you):
  "SELECT
  id, title, tags, answer_count, score, view_count, comment_count
  FROM
  `bigquery-public-data.stackoverflow.posts_questions`
  WHERE
  creation_date >= '2018-01-01'
  AND creation_date <= '2018-09-01'
  AND post_type_id = 1
  LIMIT
  100000"
  3-Save the results into Drive(it allows upload up to 1 GB)
  4- Open one of the "TF-IDF" or "Minhashşng-LSH" files in Google Colab
  5- Implement first cell and by following the orders create the link between Colab and Drive
  6- Implement the rest cells in order until the console wants an input
  7- Type your input and implement rest of the cells
