cd C:\Users\Michael\Dropbox\workspace2\MCWrapper_Client
git pull
git add --all
set /p message="Commit Message: "
git commit -m "%message%"
git push