# 定义模块当前路径
LOCAL_PATH := $(call my-dir)

# 清除当前环境变量
include $(CLEAR_VARS)

# 当前模块名
LOCAL_MODULE := hello

# 当前模块源代码
LOCAL_SRC_FILES := hello.c

# 生成动态库
include $(BUILD_SHARED_LIBRARY)