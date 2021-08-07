#!/bin/sh
#默认jvm堆大小
export JAVA_OPTS="-Xmx512m -Xms2048m"
#用于识别启动环境,同一台主机上务必不重复
ENV_ID=base
#BASE目录
BASE_PATH=.
#JAR包位置
JAR_PATH=${BASE_PATH}
#日志根目录
BASE_LOG_PATH=${BASE_PATH}/logs
#服务列表
SERVICES=()
#LIB目录
LIB_PATH=$JAR_PATH/lib

#以上内容请按照实际情况修改
#以下内容请勿修改
ALL=all
JAR_SUFFIX=-server.jar
sLen=${#SERVICES[@]}
if [ $sLen -eq 0 ]; then
  for f in $(find ${JAR_PATH} -maxdepth 1 -name "*${JAR_SUFFIX}" -exec basename {} ${JAR_SUFFIX} \;)
  do
     SERVICES=(${SERVICES[@]} $f)
  done
  sLen=${#SERVICES[@]}
  if [ $sLen -eq 0 ]; then
    echo "no valid services"
    exit 0
  fi
fi

manual(){
  services="[$ALL]"
  for s in ${SERVICES[@]}; do
    services=$(echo "$services|$s")
  done
  echo "$0 {start|show|stop} {$services}"
  exit 0
}

[ -z "$1" ] && manual
FUNC=$1
TARGET=$2
if [ -z "$TARGET" ]; then
  TARGET=$ALL
fi

#日志目录
export LOG_PATH=${BASE_LOG_PATH}/${ENV_ID}
if [ ! -d $LOG_PATH ]; then
  mkdir -p $LOG_PATH
fi

show(){
  if [ "$TARGET" = "$ALL" ]; then
    for TARGET in ${SERVICES[@]}; do
      show
    done
  else
    msgs=$(ps -ef|grep java|grep $TARGET${JAR_SUFFIX}|grep ENV_ID=$ENV_ID|grep -v grep)
    pids=$(echo ${msgs}|awk '{print $2}')
    if [ "$pids" != "" ]; then
      echo ${msgs}
    else
      echo "$TARGET is not running"
    fi
  fi
}

stop(){
  if [ "$TARGET" = "$ALL" ]; then
    for TARGET in ${SERVICES[@]}; do
      stop
    done
  else
    pids=$(ps -ef|grep java|grep $TARGET${JAR_SUFFIX}|grep ENV_ID=$ENV_ID|grep -v grep|awk '{print $2}')
    if [ "$pids" != "" ]; then
      kill "$pids"
      echo "stop $TARGET($pids) success"
    else
      echo "$TARGET is not running"
    fi
  fi
}

start(){
  if [ "$TARGET" = "$ALL" ]; then
    for TARGET in ${SERVICES[*]}; do
      start
    done
  else 
    stop
    if [ ! -f application-jiuyv.yml ]; then
      echo "application-jiuyv.yml not exists!"
      if [ ! -f application-release.yml ]; then
        echo "application-release.yml not exists! EXIT"
        exit 1
      else
        echo "copy application file"
        cp application-release.yml application-jiuyv.yml
      fi
    fi
    FN=$JAR_PATH/${TARGET}${JAR_SUFFIX}
    if [ -f $FN ]; then
      LOADER_PATH=${LIB_PATH},${LIB_PATH}/${TARGET}
      nohup java -Dloader.path=${LOADER_PATH} -jar $FN -DENV_ID=${ENV_ID}> $LOG_PATH/$TARGET.log 2>/dev/null &
      echo "start $TARGET success"
      show
    else
      echo "$FN not exist"
    fi
  fi
}

$FUNC
exit 0
