<<<<<<< .mine
#!/bin/bash
#服务清单
SERVERS="client01"
# release
release() {
  INTERFACES="front channel"
  RELEASE_DIR=release
  BASE_URL=https://168.10.25.50/svn/s20001601etc
  TAG_URL=${BASE_URL}/tags
  SOURCE_URL=${BASE_URL}/projects
  PWD=$(pwd)

  if [ "${MODULE_TYPE}" = "core" ]; then
    #若无模块名称，则进行核心代码的发布
    SOURCE_URL=${SOURCE_URL}/EtcCenter
    TAG_URL=${TAG_URL}/core
  else
    if ${MODULE_NAME} in "${INTERFACES}"; then
      #接口服务
      SOURCE_URL=${SOURCE_URL}/EtcService/${MODULE_NAME}-interface/${MODULE_NAME}-${MODULE_TYPE}
    else
      #核心服务
      SOURCE_URL=${SOURCE_URL}/EtcService/${MODULE_NAME}-service/${MODULE_NAME}-${MODULE_TYPE}
    fi
    TAG_URL=${TAG_URL}/${MODULE_TYPE}
  fi
  #checkout代码
  mvn scm:checkout -Drelease.url=${RELEASE_DIR} -Dsource.url="${SOURCE_URL}"
  #进行发布准备
  cd ${RELEASE_DIR} || return
  mvn -B release:prepare -Dsource.url="${SOURCE_URL}" -Dtag.url="${TAG_URL}"
  #执行发布
  mvn release:perform
  cd "${PWD}" || return
}

# package
copyjar() {
  MODULE_VERSION=${MODULE_VERSION:=LATEST}
  if [ ! "${TARGET_DIR}" ]; then
    TARGET_DIR=target
    rm -fr ${TARGET_DIR}
  fi
  LIB_DIR=${TARGET_DIR}/lib

  STARTER_NAME=server-spring-boot-starter
  STARTER_VERSION=LATEST
  echo "STARTER_VERSION:"${STARTER_VERSION}
  if [ "${MODULE_NAME}" ]; then
    MODULE_DIR=${LIB_DIR}/${MODULE_NAME}

    echo "   ${MODULE_DIR}"
    echo "   ${MODULE_NAME}"
    echo "   ${MODULE_VERSION}"
    mvn install -Dmodule.name="${MODULE_NAME}" -Dmodule.version=${MODULE_VERSION} -Dtarget.dir="${MODULE_DIR}"
    mv "${MODULE_DIR}"/"${MODULE_NAME}"-*.jar ${TARGET_DIR}/"${MODULE_NAME}".jar

    STARTER_VERSION=$(find ${LIB_DIR}/"${MODULE_NAME}" -maxdepth 1 -name "${STARTER_NAME}-*.jar" | sed "s/${STARTER_NAME}-//g" | sed "s/.jar//g")
    STARTER_VERSION=$(basename "${STARTER_VERSION}")
  fi

  mvn install -Dmodule.name=${STARTER_NAME} -Dmodule.version="${STARTER_VERSION}" -Dtarget.dir=${LIB_DIR}
  for d in "${LIB_DIR}"/*; do
    if [ -d "${d}" ]; then
      for f in "${d}"/*; do
        fn=$(basename "${f}")
        if [ -f ${LIB_DIR}/"${fn}" ]; then
          rm -f "${f}"
        fi
      done
    fi
  done
}

package() {
  if [ ! ${TARGET_DIR} ]; then
    TARGET_DIR=target
    rm -fr ${TARGET_DIR}
    mkdir ${TARGET_DIR}
  fi
  for m in ${SERVERS}; do
    MODULE_NAME=${m}
    echo "8888888-${MODULE_NAME}"
    copyjar
  done


  #dock
}
dock() {
  useDock=${useDock:=false}
  if [ "$useDock" = "false" ]; then
    echo "没有启动docker，跳过"
    return
  fi
  if [ -f docker/localtime ]; then
    cp docker/localtime ${TARGET_DIR}/localtime
  else
    echo "无localtime文件，跳过"
  fi
  TODAY=$(date +%Y%m%d)
  docker build -t com.jiuyv.etc/etc-service:"${TODAY}" .
}

manual() {
  echo "$0 {release|jar|package} 参数"
  echo "release："
  echo "         module_type  模块类型，可选为[api,client,server,core]，默认为core"
  echo "         module_name  模块名称，类型为core时为空"
  echo "jar："
  echo "         module_name  模块名称，若无则为核心最新依赖jar"
  echo "         module_version  模块名称，若无则为最新版本"
  echo "package：无参数"
  exit 0
}

case $1 in
"release")
  MODULE_TYPE=${2}
  MODULE_TYPE=${MODULE_TYPE:="core"}
  MODULE_NAME=${3}
  echo "${MODULE_TYPE}" ${MODULE_NAME}
  release
  ;;
"jar")
  MODULE_NAME=${2}
  MODULE_VERSION=${3}
  echo ${MODULE_NAME} "${MODULE_VERSION}"
  copyjar
  ;;
"package")
  package
  ;;
*)
  manual
  ;;
esac
||||||| .r0
=======
#!/bin/bash
#服务清单
SERVERS="channel front issue kms order trip user"
# release
release() {
  INTERFACES="client01"
  RELEASE_DIR=release
  BASE_URL=https://192.168.1.8/svn/java/learn/
  TAG_URL=https://192.168.1.8/svn/java/tags
  PWD=$(pwd)
  SOURCE_URL=${BASE_URL}/${MODULE_NAME}
  RELEASE_DIR=${RELEASE_DIR}/${MODULE_NAME}
  TAG_URL=${TAG_URL}/${MODULE_NAME}

  echo ${SOURCE_URL}
  echo ${TAG_URL}

  #checkout代码
  mvn scm:checkout -Drelease.url=${RELEASE_DIR} -Dsource.url=${SOURCE_URL}
  #进行发布准备
  cd ${RELEASE_DIR} || return
  mvn -B release:prepare -Dsource.url="${SOURCE_URL}" -Dtag.url="${TAG_URL}"
  #执行发布
  mvn release:perform
  cd "${PWD}" || return
}

# package
copyjar() {
  MODULE_VERSION=${MODULE_VERSION:=LATEST}
  if [ ! "${TARGET_DIR}" ]; then
    TARGET_DIR=target
    rm -fr ${TARGET_DIR}
  fi
  LIB_DIR=${TARGET_DIR}/lib

  STARTER_NAME=server-spring-boot-starter
  STARTER_VERSION=LATEST
  if [ "${MODULE_NAME}" ]; then
    MODULE_DIR=${LIB_DIR}/${MODULE_NAME}
    mvn install -Dmodule.name="${MODULE_NAME}"-server -Dmodule.version=${MODULE_VERSION} -Dtarget.dir="${MODULE_DIR}"
    mv "${MODULE_DIR}"/"${MODULE_NAME}"-server-*.jar ${TARGET_DIR}/"${MODULE_NAME}"-server.jar

    STARTER_VERSION=$(find ${LIB_DIR}/"${MODULE_NAME}" -maxdepth 1 -name "${STARTER_NAME}-*.jar" | sed "s/${STARTER_NAME}-//g" | sed "s/.jar//g")
    STARTER_VERSION=$(basename "${STARTER_VERSION}")
  fi

  mvn install -Dmodule.name=${STARTER_NAME} -Dmodule.version="${STARTER_VERSION}" -Dtarget.dir=${LIB_DIR}
  for d in "${LIB_DIR}"/*; do
    if [ -d "${d}" ]; then
      for f in "${d}"/*; do
        fn=$(basename "${f}")
        if [ -f ${LIB_DIR}/"${fn}" ]; then
          rm -f "${f}"
        fi
      done
    fi
  done
}

package() {
  if [ ! ${TARGET_DIR} ]; then
    TARGET_DIR=target
    rm -fr ${TARGET_DIR}
    mkdir ${TARGET_DIR}
  fi
  for m in ${SERVERS}; do
    MODULE_NAME=${m}
    copyjar
  done

  if [ -f etc.sh ]; then
    cp etc.sh ${TARGET_DIR}
    chmod 755 ${TARGET_DIR}/etc.sh
  else
    echo "无启动脚本etc.sh，跳过"
  fi
  if [ -f ../config/application-jiuyv.yml ]; then
    cp ../config/application-jiuyv.yml ${TARGET_DIR}/application-release.yml
  else
    echo "无配置文件application-jiuyv.yml，跳过"
  fi
  dock
}
dock() {
  useDock=${useDock:=false}
  if [ "$useDock" = "false" ]; then
    echo "没有启动docker，跳过"
    return
  fi
  if [ -f docker/localtime ]; then
    cp docker/localtime ${TARGET_DIR}/localtime
  else
    echo "无localtime文件，跳过"
  fi
  TODAY=$(date +%Y%m%d)
  docker build -t com.jiuyv.etc/etc-service:"${TODAY}" .
}

manual() {
  echo "$0 {release|jar|package} 参数"
  echo "release："
  echo "         module_name  模块名称"
  echo "jar："
  echo "         module_name  模块名称，若无则为核心最新依赖jar"
  echo "         module_version  模块名称，若无则为最新版本"
  echo "package：无参数"
  exit 0
}

case $1 in
"release")
  MODULE_NAME=${2}
  echo  ${MODULE_NAME}
  release
  ;;
"jar")
  MODULE_NAME=${2}
  MODULE_VERSION=${3}
  echo ${MODULE_NAME} "${MODULE_VERSION}"
  copyjar
  ;;
"package")
  package
  ;;
*)
  manual
  ;;
esac
>>>>>>> .r74
