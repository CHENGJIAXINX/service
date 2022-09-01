rd /s /Q .\target\dependency
call mvn dependency:copy-dependencies -Dmdep.useRepositoryLayout=false


pause