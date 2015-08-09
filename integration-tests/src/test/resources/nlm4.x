 uint64
      typedef unsigned hyper uint64;

   int64
      typedef hyper int64;

   uint32
      typedef unsigned long uint32;

   int32
      typedef long int32;

enum nlm4_stats {
         NLM4_GRANTED = 0,
         NLM4_DENIED = 1,
         NLM4_DENIED_NOLOCKS = 2,
         NLM4_BLOCKED = 3,
         NLM4_DENIED_GRACE_PERIOD = 4,
         NLM4_DEADLCK = 5,
         NLM4_ROFS = 6,
         NLM4_STALE_FH = 7,
         NLM4_FBIG = 8,
         NLM4_FAILED = 9
      };

struct nlm4_holder {
           bool     exclusive;
           int32    svid;
           netobj   oh;
           uint64   l_offset;
           uint64   l_len;
      };

struct nlm4_lock {
           string   caller_name<LM_MAXSTRLEN>;
           netobj   fh;
           netobj   oh;
           int32    svid;
           uint64   l_offset;
           uint64   l_len;
      };

 struct nlm4_share {
           string      caller_name<LM_MAXSTRLEN>;
           netobj      fh;
           netobj      oh;
           fsh4_mode   mode;
           fsh4_access access;
      };


 version NLM4_VERS {
          void
             NLMPROC4_NULL(void)                  = 0;

          nlm4_testres
             NLMPROC4_TEST(nlm4_testargs)         = 1;

          nlm4_res
             NLMPROC4_LOCK(nlm4_lockargs)         = 2;

          nlm4_res
             NLMPROC4_CANCEL(nlm4_cancargs)       = 3;

          nlm4_res
             NLMPROC4_UNLOCK(nlm4_unlockargs)     = 4;


          nlm4_res
             NLMPROC4_GRANTED(nlm4_testargs)      = 5;

          void
             NLMPROC4_TEST_MSG(nlm4_testargs)     = 6;

          void
             NLMPROC4_LOCK_MSG(nlm4_lockargs)     = 7;

          void
             NLMPROC4_CANCEL_MSG(nlm4_cancargs)   = 8;

          void
             NLMPROC4_UNLOCK_MSG(nlm4_unlockargs) = 9;

          void
             NLMPROC4_GRANTED_MSG(nlm4_testargs) = 10;

          void
             NLMPROC4_TEST_RES(nlm4_testres)     = 11;

          void
             NLMPROC4_LOCK_RES(nlm4_res)         = 12;

          void
             NLMPROC4_CANCEL_RES(nlm4_res)       = 13;

          void
             NLMPROC4_UNLOCK_RES(nlm4_res)       = 14;

          void
             NLMPROC4_GRANTED_RES(nlm4_res)      = 15;

          nlm4_shareres
             NLMPROC4_SHARE(nlm4_shareargs)      = 20;

          nlm4_shareres
             NLMPROC4_UNSHARE(nlm4_shareargs)    = 21;

          nlm4_res
             NLMPROC4_NM_LOCK(nlm4_lockargs)     = 22;

          void
             NLMPROC4_FREE_ALL(nlm4_notify)      = 23;

       } = 4;

