git filter-branch --env-filter \
    'if [ "$GIT_COMMIT" == "00d51222073ebb8feb3adeedcf732c14210b1b0a" ]
         then
                  export GIT_AUTHOR_DATE="2021-01-30T18:25:12-05:00"
                  export GIT_COMMITTER_DATE="2021-01-30T18:25:12-05:00"
     fi'