## Java Test: 
   
   ·     Create an in-memory database
   <br />
   - Credentials cfa_admin / p@$$w0rd!
   
   ·     Create a data model that fulfills the following requirements
   <br />
   - Track users, movies, and movie ratings by users
   <br />
   - Think through the modeling exercise and decide what tables fields will be useful/required
   <br />
   - Save the DDL for the database to a file called "ddl.sql".
   
   ·     Populate each of the tables with some sample data, same these inserts in a file called "sample_data.sql". 
   <br />
   Read the queries below as they will require certain sample data to be populated.
   
   ·     Using Java/Spring, write RESTful API methods that return each of the following. We will evaluate based on correctness and code style.
   <br />
   - Given a parameter of "age", return the top 10 movies ordered by average rating.
   <br />
   - Given a userId, return all movies that user has watched and the total count, as well as the rating for that movie.
   <br />
   - Given a parameter of "state", return the top 20 movies by average rating when that movie has been watched between 6pm and midnight, EST.
   <br />
   - Given a parameter of "movieId", return its average rating.
   <br />
   - Given a genre such as "action" and a userId, return the top 5 movies for that genre by average rating, where the rating was made by other users within 5 years
    (older and younger) of the user's age.
   
   ·     AFTER running your code, we will attempt to insert some additional data, perhaps for a movie that already exists. 
   <br />
   Ensure the behavior of the database will support this properly (referential integrity, proper primary keys, etc). 
   
   Give consideration to where indexes may be needed (and include in ddl.sql if any are created).
   
   ·     Gzip the completed database, your API code, plus the ddl.sql and sample_data.sql and submit them
   
   --------------------