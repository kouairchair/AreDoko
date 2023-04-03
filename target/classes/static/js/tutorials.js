// $(document).ready(function () {
//   navigator.serviceWorker.getRegistrations().then(function (registrations) {
//     for (let registration of registrations) {
//       registration.unregister();
//       console.log('testtest unregister');
//     }

//     window.OneSignal = window.OneSignal || [];
//     OneSignal.push(function () {
//       OneSignal.SERVICE_WORKER_PARAM = { scope: '/' };
//       OneSignal.SERVICE_WORKER_PATH = 'OneSignalSDKWorker.js'
//       OneSignal.init({
//         appId: "119fd1aa-f10d-4244-bc48-1e68614048aa",
//         safari_web_id: "web.onesignal.auto.412ff56c-6955-417a-b410-cc97b21af240",
//         notifyButton: {
//           enable: true,
//         },
//       });
//     });
//   });

//   $(".btn-delete").on("click", function (e) {
//     e.preventDefault();
//     link = $(this);

//     tutorialTitle = link.attr("tutorialTitle");
//     $("#yesBtn").attr("href", link.attr("href"));
//     $("#confirmText").html("Do you want to delete the Tutorial \<strong\>" + tutorialTitle + "\<\/strong\>?");
//     $("#confirmModal").modal();
//   });

//   $("#btnClear").on("click", function (e) {
//     e.preventDefault();
//     $("#keyword").text("");
//     window.location = "[[@{/tutorials}]]";
//   });

//   return;

//   async function register() {
//     // A service worker must be registered in order to send notifications on iOS
//     // const registration = await navigator.serviceWorker.register(
//     //   "service-worker.js",
//     //   {
//     //     scope: "./templates",
//     //   }
//     // ).then(function (reg) {
//     //   console.log("Service worker successfully registered.", reg);
//     //   if (reg.installing) {
//     //     reg.installing.onstatechange = function (e) {
//     //       if (e.target.state == 'installed') {
//     //         console.log("Service worker successfully installed.");
//     //       } else if (e.target.state == 'redundant') {
//     //         console.log("Service worker failed to install.");
//     //       }
//     //     };
//     //   }
//     // }).catch(function (err) {
//     //   console.error("Service worker failed to register.", err);
//     // });

//     $("#btnNotif").on("click", function (e) {
//       e.preventDefault();

//     });
//     // const button = document.getElementById("subscribe");
//     // button.addEventListener("click", async () => {
//     //   // Triggers popup to request access to send notifications
//     //   const result = await window.Notification.requestPermission();

//     //   // If the user rejects the permission result will be "denied"
//     //   if (result === "granted") {
//     //     // You must use the service worker notification to show the notification
//     //     // Using new Notification("Hello World", { body: "My first notification on iOS"}) does not work on iOS
//     //     // despite working on other platforms
//     //     await registration.showNotification("Hello World", {
//     //       body: "My first notification on iOS",
//     //     });
//     //   }
//     // });
//   }

//   async function run() {
//     navigator.serviceWorker.getRegistrations().then(function (registrations) {
//       for (let registration of registrations) {
//         registration.unregister();
//         console.log('testtest unregister');
//       }

//       register();
//     });
//   }

//   // run();

//   // Adding an empty touch listener will make :active CSS pseudo selector
//   // work in order to style taps on elements. Joy.
//   document.addEventListener('touchstart', (evt) => { });

//   // Service Worker API が存在しているかをチェック
//   // if ('serviceWorker' in navigator) {
//   //   navigator.serviceWorker.register('/sw.js').then(function (registration) {
//   //     // 登録成功
//   //     console.log('ServiceWorker registration successful with scope: ', registration.scope);
//   //   }).catch(function (err) {
//   //     // 登録失敗 :(
//   //     console.log('ServiceWorker registration failed: ', err);
//   //   });
//   // }

//   // let lastHeight: number | null = null;

//   // const setAppHeight = debounce(() => {
//   //   const doc = document.documentElement;
//   //   const height = window.innerHeight;

//   //   if (height != lastHeight) {
//   //     doc.style.setProperty('--app-height', `${height - MAGIC_NUMBER}px`);
//   //     lastHeight = height;
//   //   }
//   // }, 100);

//   // This is the magic offset which one can subtract in order to hide scrollbars
//   // AT LEAST ON MY PHONE. YMMV.
//   // const MAGIC_NUMBER = 3;

//   /** This is solving the STILL outstanding problem of using
//   * height: 100vh on Mobile Safari. The problem is outlined here:
//   * https://chanind.github.io/javascript/2019/09/28/avoid-100vh-on-mobile-web.html
//   *
//   * Instead, we control the height of a CSS variable which is mirroring
//   * the window.innerHeight property.
//   */
//   // const fixMobileHeight = () => {
//   //   window.addEventListener('resize', setAppHeight);

//   //   setAppHeight();

//   //   return () => window.removeEventListener('resize', setAppHeight);
//   // };

//   // // Util
//   // const debounce = (func: (...args: unknown[]) => unknown, wait: number) => {
//   //   let timeout: NodeJS.Timeout;

//   //   return (...args: unknown[]) => {
//   //     const later = () => {
//   //       clearTimeout(timeout);
//   //       func(...args);
//   //     };

//   //     clearTimeout(timeout);
//   //     timeout = setTimeout(later, wait);
//   //   };
//   // };

//   // fixMobileHeight();
//   self.addEventListener('push', (event) => {
//     let pushMessageJSON = event.data.json();
//     event.waitUntil(self.registration.showNotification(pushMessageJSON.title, {
//       body: pushMessageJSON.body,
//       tag: pushMessageJSON.tag,
//       actions: [{
//         action: pushMessageJSON.actionURL,
//         title: pushMessageJSON.actionTitle,
//       }]
//     }));
//   });
// });

// function changePageSize() {
//   $("#searchForm").submit();
// }
