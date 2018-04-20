const puppeteer = require('puppeteer');

(async () => {
  const browser = await puppeteer.launch();
  const page = await browser.newPage();
  await page.goto('https://zba.jp/tsushin-highschool/');

  await page.screenshot({
    path: 'example.png',
    fullPage: true,
    width: 1200
  });

  await browser.close();
})();
